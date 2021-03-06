package adminCronJob.portlet;

import adminCronJob.constants.AdminCronJobPortletKeys;

import com._42Penguins.gosign.model.EntDoc;
import com._42Penguins.gosign.service.EntDocLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author razim
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=admin.goSign",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=adminCronJob Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminCronJobPortletKeys.AdminCronJob,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminCronJobPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(AdminCronJobPortlet.class);

	public void doAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		_log.info("###################################################");
		_log.info("#                  Reminder log                   #");
		_log.info("###################################################");
		_log.info("START: Deadline Reminder Function");

		/*
		 * Logging using liferay logging
		 */

		try {

			DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			long sleeptimesecs = 5;
			long sleeptime = sleeptimesecs * 1000;

			List<EntDoc> docDataList = EntDocLocalServiceUtil.getEntDocs(-1, -1);

			_log.info("Listing all document");

			for (EntDoc listdoc : docDataList) {
				String deadlineDate = listdoc.getDoc_deadline();
				String docStatus = listdoc.getDoc_status();
				long docId = listdoc.getDocId();
				LocalDate deadlineDateFormat = LocalDate.parse(deadlineDate, formatterDate);
				LocalDate nowDate = LocalDate.now();

				_log.info("Comparing current date with deadline");
				/*
				 * Check if status expired. Ignore if already expired
				 */
				if (docStatus.equals("Expired")) {
					_log.info("ID: " + docId + " " + docStatus);
					_log.info("========================================");
				} else if (docStatus.equals("Signed")) {
					_log.info("ID: " + docId + " " + docStatus);
					_log.info("========================================");
				} else if (docStatus.equals("Verified")) {
					_log.info("ID: " + docId + " " + docStatus);
					_log.info("========================================");
				} else if (docStatus.equals("Rejected")) {
					_log.info("ID: " + docId + " " + docStatus);
					_log.info("========================================");
				} else if (docStatus.equals("Pending") || docStatus.equals("Justify")) {
					_log.info("ID: " + docId + " " + docStatus);
					_log.info("Checking deadline...");

					/*
					 * Update status to rejected if nowDate > deadline
					 */
					if (nowDate.isAfter(deadlineDateFormat)) {

						_log.info("ID: " + docId + " expiring. Updating status in DB ");
						listdoc.setDoc_status("Expired");
						listdoc = EntDocLocalServiceUtil.updateEntDoc(listdoc);
						_log.info("========================================");

					} else if (nowDate.equals(deadlineDateFormat)) {
						/*
						 * nowDate equal deadline: send email reminder
						 */
						_log.info("ID: " + docId + " last day. Sending email.");

						try {

							EntDoc docData = EntDocLocalServiceUtil.getEntDoc(docId);

							InternetAddress fromAddress = null;
							InternetAddress toAddress = null;

							fromAddress = new InternetAddress("noreply@myiexplorer.com");
							toAddress = new InternetAddress(docData.getSign_email());
							MailMessage mailMessage = new MailMessage();

							mailMessage.setTo(toAddress);
							mailMessage.setFrom(fromAddress);
							mailMessage.setSubject("Reminder! Last day to sign document ID " + docId);

							mailMessage.setBody(""

									+ "<font face=\"arial\" size=\"2\">" + "<p>Dear Signer,</p> "
									+ "<p>You have pending signature request that need your immediate action (Request ID: "
									+ docId + ")</p>" + "<p>This request was submitted by " + docData.getReq_name()
									+ ". Today is last day to sign the document. "
									+ "Please login and review as soon as possible.</p>"
									+ "If you need clarification on this request, please contact "
									+ docData.getReq_name() + " (" + docData.getReq_email() + ") for more details."
									+ "<br>" + "<p>Sincerely,<br>" + "GoSign Team<br>" + "</p>" + "</font>");

							mailMessage.setHTMLFormat(true);
							MailServiceUtil.sendEmail(mailMessage);
							System.out.println("Reminder email has been sent to signer");
							System.out.println("Delay for " + sleeptimesecs + " seconds for next process");

							Thread.sleep(sleeptime);

							_log.info("========================================");

						} catch (AddressException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (nowDate.isBefore(deadlineDateFormat)) {
						_log.info("ID: " + docId + " deadline still valid");
						_log.info("========================================");
					} else {
						_log.info("ID: " + docId + " incorrect date");
						_log.info("========================================");
					}

				} else {
					_log.info("Status not found");
					_log.info("========================================");
				}

			}
			
			SessionMessages.add(actionRequest, "request_processed", "Job completed!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			_log.info("END: Deadline Reminder Function");
		}

	}
	
}