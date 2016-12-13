using System;


namespace CustomApplication
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["appToken"] != null)
            {
                if ((Session["username"] != null && !Session["username"].Equals("")) || (Request.QueryString["username"] != null && !Request.QueryString["username"].Equals("")))
                {
                    if (Request.QueryString["logout"] != null && Request.QueryString["logout"].Equals("true"))
                    {
                        Session.Clear();
                        Session.Abandon();
                        Response.Redirect("/Login.aspx");
                    }
                }
                else
                {
                    Response.Redirect("/Login.aspx");
                }
            }
            else
            {
                Response.Redirect("/Login.aspx");
            }


        }
    }
}