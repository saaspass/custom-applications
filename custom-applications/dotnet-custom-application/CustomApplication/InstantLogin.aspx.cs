using System;

namespace CustomApplication
{
    public partial class InstantLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Message message = new Message();
            message.reqSession = Request.Headers["session"];
            message.reqTracker = Request.Headers["tracker"];
            message.reqUsername = Request.Headers["username"];

            if (!AppMethods.TrackerIdValidation(message.reqUsername, message.reqTracker, AppMethods.GetApplicationToken()))
                return;
            else
            {
                if (!string.IsNullOrWhiteSpace(message.reqSession) && !string.IsNullOrEmpty(message.reqTracker) && !string.IsNullOrEmpty(message.reqUsername))
                {
                    Session["username"] = message.reqUsername;
                    ClientAdapter.Instance.SendMessage(message);
                }
            }
        }
    }
}