using System;

namespace CustomApplication
{
    public partial class Unregister : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["appToken"] != null )
            {
                if (Session["username"] != null)
                {
                    username.Text = Session["username"].ToString();
                }
            }
            else
            {
                Response.Redirect("/Login.aspx");
            }
        }

        protected void unregister_Click(object sender, EventArgs e)
        {
            if (Session["appToken"] != null && Session["username"] != null)
            {
                bool unregisterResult = AppMethods.UnRegistration(Session["username"].ToString(), Session["appToken"].ToString());
                if (unregisterResult)
                {
                    unregisterWarning.Text = AppMethods.ErrMessage;
                    Session.Clear();
                }
                else
                {
                    unregisterWarning.Text = AppMethods.ErrMessage;
                }
            }
            else
            {
                unregisterWarning.Text = AppMethods.ErrMessage;
            }
        }
    }
}