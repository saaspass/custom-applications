using System;
using System.Web;


namespace CustomApplication
{
    public partial class Registration : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["appToken"] != null)
            {
                //Response.Write("apptoken session=" + Session["appToken"].ToString());
            }
            else
            {
                Response.Redirect("/Login.aspx");
            }
        }

        protected void Page_PreRender(object sender, EventArgs e)
        {
            if (Session["sessionIR"] != null)
            {
                ClientScript.RegisterStartupScript(this.GetType(), "ActivateWaitingLoop", "waitEvent();", true);
            }
        }

        protected void registerByAdmin_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null)
            {
                if (!email.Text.Equals(""))
                {
                    bool registrationResult = AppMethods.RegistrationByAdmin(email.Text, adAccount1.Checked, accountOwner.Text, Session["appToken"].ToString());
                    if (registrationResult)
                    {
                        Session["username"] = email.Text.ToString();
                    }

                    registrationWarning.Text = AppMethods.ErrMessage;
                }
                else
                {
                    registrationWarning.Text = "Please enter e-mail.";
                }
            }
            else
            {
                Response.Write("Session Expired!");
                Response.Redirect("/Login.aspx");
            }
        }

        protected void registerByUser_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null)
            {
                if (!username.Text.Equals("") && !saaspassId.Text.Equals("") && !otp.Text.Equals(""))
                {
                    bool registrationResult = AppMethods.RegistrationByUser(username.Text, adAccount2.Checked, saaspassId.Text, otp.Text, Session["appToken"].ToString());
                    if (registrationResult)
                    {
                        Session["username"] = username.Text.ToString();
                    }
                    registrationWarning.Text = AppMethods.ErrMessage;
                }
                else
                {
                    registrationWarning.Text = "Please enter username, saaspassId and one time password";
                }
            }
            else
            {
                Response.Write("Session Expired!");
                Response.Redirect("/Login.aspx");
            }
        }

        protected void getRegistrationBarcode_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null && !Session["appToken"].Equals(""))
            {
                registerBarcode.ImageUrl = null;
                string session = HttpContext.Current.Session.SessionID;
                registerBarcode.ImageUrl = AppMethods.GetBarcodeImage(Session["appToken"].ToString(), session, "IR");
                ClientAdapter.Instance.Join(session);
                Session["sessionIR"] = session;
            }
            else
            {
                Response.Write("Session Expired!");
                Response.Redirect("/Login.aspx");
            }
        }

        protected void getRegistrationAndLoginBarcode_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null && !Session["appToken"].Equals(""))
            {
                registerBarcode.ImageUrl = null;
                string session = HttpContext.Current.Session.SessionID;
                registerBarcode.ImageUrl = AppMethods.GetBarcodeImage(Session["appToken"].ToString(), session, "ILIR");
                ClientAdapter.Instance.Join(session);
                Session["sessionIR"] = session;
            }
            else
            {
                Response.Write("Session Expired!");
                Response.Redirect("/Login.aspx");
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null)
            {
                if (!email.Text.Equals(""))
                {
                    for (int i = 0; i < 35; i++)
                    {
                        bool registrationResult = AppMethods.RegistrationByAdmin(email.Text, adAccount1.Checked, accountOwner.Text, Session["appToken"].ToString());
                        registrationWarning.Text = AppMethods.ErrMessage;
                    }
                }
                else
                {
                    registrationWarning.Text = "Please enter e-mail.";
                }
            }
            else
            {
                Response.Write("Session Expired!");
                Response.Redirect("/Login.aspx");
            }
        }
    }
}