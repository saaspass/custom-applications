using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CustomApplication
{
    public partial class MainMaster : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["username"] != null)
            {
                pnLoginTrue.Visible = true;
                lblUsername.Text = Session["username"].ToString();
            }
            else if (Request.QueryString["username"]!=null)
            {
                pnLoginTrue.Visible = true;
                lblUsername.Text = Request.QueryString["username"];
                Session["username"] = Request.QueryString["username"];
            }
            else
            {
                pnLoginFalse.Visible = true;
            }
        }
    }
}