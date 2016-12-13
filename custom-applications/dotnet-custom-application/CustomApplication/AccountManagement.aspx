<%@ Page Title="" Language="C#" MasterPageFile="~/MainMaster.Master" AutoEventWireup="true" CodeBehind="AccountManagement.aspx.cs" Inherits="CustomApplication.AccountManagement" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div style="width: 45%; margin-right: auto; margin-left: auto; margin-top: 25px;">
        <h3 style="color: #33719a;">Add Account</h3>
        <div style="margin: 10px; padding: 10px; background-color: #e5e8ea;">
            <p>
                <asp:TextBox ID="username" runat="server" Style="width: 90%; height: 25px;" placeholder="Username (*)"></asp:TextBox>
            </p>
            <p>
                <asp:TextBox ID="grouplist" runat="server" Style="width:90%; height: 25px;" placeholder="Grouplist(optional)"></asp:TextBox>
            </p>
            <p>
                <asp:TextBox ID="accountowner" runat="server" Style="width: 90%; height: 25px;" placeholder="Account Owner(optional)"></asp:TextBox>
            </p>
            <p>
                <asp:Button ID="addAccount" runat="server" Text="Add Account" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="addAccount_Click" />
            </p>

            <asp:Label ID="addAccountWarning" runat="server" Style="color: red;"></asp:Label>
        </div>

        <h3 style="color: #33719a;">Verify Account</h3>
        <div style="margin: 10px; padding: 10px; background-color: #e5e8ea;">
            <p>
                <asp:TextBox ID="verifyUsername" runat="server" Style="width: 90%; height: 25px;" placeholder="Username(*)"></asp:TextBox>
            </p>
            <p>
                <asp:TextBox ID="accountownerverify" runat="server" Style="width: 90%; height: 25px;" placeholder="Account Owner (optional)"></asp:TextBox>
            </p>
            <p>
                <asp:CheckBox ID="isadaccount" runat="server" Text="Is Ad Account (optional)" />
            </p>
            <p>
                <asp:Button ID="verifyAccount" runat="server" Text="Verify Account" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="verifyAccount_Click" />
            </p>
            <asp:Label ID="verifyAccountWarning" runat="server" Style="color: red;"></asp:Label>
        </div>

        <h3 style="color: #33719a;">Remove Account</h3>
        <div style="margin: 10px; padding: 10px;background-color: #e5e8ea;">
            <p>
                <asp:TextBox ID="removeUsername" runat="server" Style="width: 90%; height: 25px;" placeholder="Username(*)"></asp:TextBox>
            </p>
            <p>
                <asp:Button ID="removeAccount" runat="server" Text="Remove Account" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="removeAccount_Click" />
            </p>
            <asp:Label ID="removeAccountWarning" runat="server" Style="color: red;"></asp:Label>
        </div>


    </div>

</asp:Content>
