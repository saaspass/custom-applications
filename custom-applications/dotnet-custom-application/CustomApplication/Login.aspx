<%@ Page Title="" Language="C#" MasterPageFile="~/MainMaster.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="CustomApplication.Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <!-- Receive messages -->
    <asp:ScriptManager ID="ScriptManager1" runat="server" AsyncPostBackTimeout="2147483647">
        <Services>
            <asp:ServiceReference Path="~/Dispatcher.asmx" />
        </Services>
    </asp:ScriptManager>
    <script type="text/javascript">
        function waitEvent() {
            CustomApplication.Dispatcher.WaitMessage("<%= Session["session"] %>",

            function (response) {
                displayMessage(response);
                setTimeout(waitEvent, 0);
            },
            function () {

                setTimeout(waitEvent, 0);
            });
        }

        function displayMessage(message) {
            if (message != null) {
                window.location.href = "/Default.aspx?username=" + message;
            }
        }
    </script>

    <div style="margin-top: 30px;">
        <div class="login" style="width: 40%; height: 500px; float: left; text-align: center; background-color: #e5e8ea; margin: 10px;">
            <h2 style="color: #33719a;">MANUAL</h2>
            <p>
                <asp:TextBox ID="username" runat="server" Style="width: 60%; height: 25px;" placeholder="Username"></asp:TextBox>
                <asp:Button ID="pushLoginButton" runat="server" Text="Push Login" Width="30%" Height="25px" OnClick="pushLoginButton_Click" />
            </p>
            <p>
                <asp:TextBox ID="otp" runat="server" Style="width: 90%; height: 25px;" placeholder="One-Time Password" MaxLength="6"></asp:TextBox>
            </p>
            <p>
                <asp:Button ID="login" runat="server" Text="Login" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="login_Click" />
            </p>
            <asp:Label ID="loginWarning" runat="server" ForeColor="#CC3300"></asp:Label>
        </div>
        <div class="scan" style="width: 40%; height: 500px; float: left; text-align: center; background-color: #e5e8ea; margin: 10px;">
            <h2 style="color: #33719a;">SCAN</h2>
            <asp:ImageMap ID="barcodeImageGrid" runat="server"></asp:ImageMap>
        </div>
        <asp:Literal ID="ltlProximity" runat="server"></asp:Literal>

    </div>
</asp:Content>
