using System;

namespace CustomApplication
{
    public partial class AccountManagement : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Session["companyToken"] = AppMethods.GetCompanyToken() != null ? AppMethods.GetCompanyToken() : null;
            if (Session["companyToken"] == null)
            {
                Response.Write("company token cannot given.");
            }
        }

        protected void addAccount_Click(object sender, EventArgs e)
        {
            if (!username.Text.Equals(""))
            {
                if (Session["companyToken"] != null)
                {
                    bool addAccountResult = AppMethods.AddAccount(username.Text, grouplist.Text, accountowner.Text, Session["companyToken"].ToString());
                    addAccountWarning.Text = AppMethods.ErrMessage;
                }
                else
                {
                    addAccountWarning.Text = "Session Expired!!";
                }
            }
            else
            {
                addAccountWarning.Text = "username is required!";
            }
        }

        protected void verifyAccount_Click(object sender, EventArgs e)
        {
            if (Session["companyToken"] != null)
            {
                bool verifyAccountResult = AppMethods.VerifyAccount(verifyUsername.Text, isadaccount.Checked, accountownerverify.Text, Session["companyToken"].ToString());
                verifyAccountWarning.Text = AppMethods.ErrMessage;
            }
            else
            {
                verifyAccountWarning.Text = "Session Expired!!";
            }
        }

        protected void removeAccount_Click(object sender, EventArgs e)
        {
            if (Session["companyToken"] != null)
            {
                bool removeAccountResult = AppMethods.RemoveAccount(removeUsername.Text, Session["companyToken"].ToString());
                removeAccountWarning.Text = AppMethods.ErrMessage;
            }
            else
            {
                removeAccountWarning.Text = "Session Expired!!";
            }
        }

    }
}