using System;
namespace CustomApplication
{
    public partial class Sso : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                string tracker = Request.QueryString["tracker"];
                string username = Request.QueryString["account"];
                if (username!=null && !username.Equals(""))
                {
                    if (AppMethods.TrackerIdValidation(username, tracker, AppMethods.GetApplicationToken()))
                    {
                        Session["username"] = username;
                        Response.Redirect("/Default.aspx");

                    }
                    else
                    {
                        Response.Write("tracker data or account information cannot get.");
                    }
                }
            }
            catch (Exception)
            {
                Response.Write("tracker data or account information cannot get.");
                throw;
            }
        }
    }
}