using System;
using System.Web;

namespace CustomApplication
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                Session["appToken"] = AppMethods.GetApplicationToken();
                if (Session["appToken"] != null && !Session["appToken"].Equals(""))
                {
                    string session = HttpContext.Current.Session.SessionID;
                    barcodeImageGrid.ImageUrl = AppMethods.GetBarcodeImage(Session["appToken"].ToString(), session,"IL");
                    ClientAdapter.Instance.Join(session);
                    Session["session"] = session;
                    string bluetoothImage = AppMethods.GetBarcodeImage(Session["appToken"].ToString(), HttpContext.Current.Session.SessionID, "BT");
                    ltlProximity.Text = "<iframe name='we' id='12'  frameborder='no' scrolling='auto' height='200px' width='100%' src='"+ bluetoothImage + "' style='left:0; background-color:#B8B8B8;visibility: hidden;'></iframe>";
                }
                else
                {
                    Response.Write("Session Expired!");
                }
            }
            catch (Exception){}
        }
        protected void Page_PreRender(object sender, EventArgs e)
        {
            if (Session["session"] != null)
            {
                ClientScript.RegisterStartupScript(this.GetType(), "ActivateWaitingLoop", "waitEvent();", true);
            }
        }

        protected void login_Click(object sender, EventArgs e)
        {
            if (!username.Text.Equals("") && !otp.Text.Equals(""))
            {
                if (Session["appToken"] != null)
                {
                    bool otpResult = AppMethods.OTPCheck(username.Text, otp.Text, Session["appToken"].ToString());

                    if (otpResult)
                    {
                        Session["username"] = username.Text.ToString();
                        Response.Redirect("/Default.aspx");
                    }
                    else
                    {
                        loginWarning.Text = AppMethods.ErrMessage;
                    }
                }
                else
                {
                    loginWarning.Text = AppMethods.ErrMessage;

                }
            }
        }

        protected void pushLoginButton_Click(object sender, EventArgs e)
        {
            if (!username.Text.Equals(""))
            {
                try
                {
                    if (Session["appToken"] == null)
                    {
                        Session["appToken"] = AppMethods.GetApplicationToken();
                    }
                    else
                    {
                        string session = HttpContext.Current.Session.SessionID;
                        bool pushLogin = AppMethods.PushLogin(username.Text, Session["session"].ToString(), Session["appToken"].ToString());
                        if (pushLogin)
                        {
                            Session["username"] = username.Text.ToString();
                            ClientAdapter.Instance.Join(session);
                            Session["session"] = session;
                        }
                    }

                }
                catch (Exception) { }
            }
        }
    }
}