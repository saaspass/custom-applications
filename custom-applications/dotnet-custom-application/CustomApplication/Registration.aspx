<%@ Page Title="" Language="C#" MasterPageFile="~/MainMaster.Master" AutoEventWireup="true" CodeBehind="Registration.aspx.cs" Inherits="CustomApplication.Registration" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
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
            CustomApplication.Dispatcher.WaitMessage("<%= Session["sessionIR"] %>",
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
                alert('Registration complete successfully.');
            }
        }
    </script>
    <div style="margin-top: 30px;">
        <h2 style="color: #33719a; text-align: center;">REGISTRATION PAGE</h2>

        <div class="login" style="width: 45%; height: 500px; float: left; text-align: center;">
            <h2 style="color: #33719a;">MANUAL</h2>
            <div style="background-color: #e5e8ea">
                <h4>Register By Admin</h4>
                <p>
                    <asp:TextBox ID="email" runat="server" Style="width: 90%; height: 25px;" placeholder="E-mail *"></asp:TextBox>
                </p>
                <p>
                    <asp:TextBox ID="accountOwner" runat="server" Style="width: 90%; height: 25px;" placeholder="Account Owner"></asp:TextBox>
                </p>
                <p>
                    <asp:CheckBox ID="adAccount1" runat="server" Text="Ad Account" />
                </p>
                <p>
                    <asp:Button ID="registerByAdmin" runat="server" Text="Registration By Admin" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="registerByAdmin_Click" />
                </p>    
               <p>
                    <asp:Button ID="Button1" runat="server" Text="Registration By Admin - Rate Limit Test" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="Button1_Click" />
                </p>
            </div>
            <div style="background-color: #e5e8ea">
                <h4>Register By User</h4>
                <p>
                    <asp:TextBox ID="username" runat="server" Style="width: 90%; height: 25px;" placeholder="Simple Username *"></asp:TextBox>
                </p>
                <p>
                    <asp:TextBox ID="saaspassId" runat="server" Style="width: 90%; height: 25px;" placeholder="Saaspass Id *"></asp:TextBox>
                </p>
                <p>
                    <asp:TextBox ID="otp" runat="server" Style="width: 90%; height: 25px;" placeholder="One-Time Password *" MaxLength="6"></asp:TextBox>
                </p>
                <p>
                    <asp:CheckBox ID="adAccount2" runat="server" Text="Ad Account" />
                </p>
                <p>
                    <asp:Button ID="registerByUser" runat="server" Text="Register By User" Style="width: 90%; height: 25px; color: #33719a; font-weight: bold;" OnClick="registerByUser_Click" />
                </p>
            </div>
            <asp:Label ID="registrationWarning" runat="server" ForeColor="#CC3300" Font-Bold="true"></asp:Label>

        </div>
        <div class="scan" style="width: 45%; height: 500px; float: left; text-align: center; margin-left:10px;">
            <h2 style="color: #33719a;">SCAN</h2>
            <div style="background-color: #e5e8ea; height:460px;">
                <p>
                    <asp:Button ID="getRegistrationBarcode" runat="server" Text="Get Registration Barcode" OnClick="getRegistrationBarcode_Click" Style="width: 90%; height: 25px; color: #000000; font-weight: bold;" />
                </p>
                <p>
                    <asp:Button ID="getRegistrationAndLoginBarcode" runat="server" Text="Get Login & Registration Barcode" OnClick="getRegistrationAndLoginBarcode_Click" Style="width: 90%; height: 25px; color: #000000; font-weight: bold;" />
                </p>
                <asp:ImageMap ID="registerBarcode" runat="server"></asp:ImageMap>
            </div>
        </div>
    </div>
</asp:Content>
