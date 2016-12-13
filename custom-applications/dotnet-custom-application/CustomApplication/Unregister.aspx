<%@ Page Title="" Language="C#" MasterPageFile="~/MainMaster.Master" AutoEventWireup="true" CodeBehind="Unregister.aspx.cs" Inherits="CustomApplication.Unregister" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div style="width: 70%; margin-right: auto; margin-left: auto; margin-top: 25px;">
        <asp:Label ID="username" runat="server"></asp:Label><t>
        <asp:Button ID="unregister" runat="server" Text="Unregister" OnClick="unregister_Click" />
        <asp:Label ID="unregisterWarning" runat="server" style="color:red;"></asp:Label>
    </div>
</asp:Content>
