using Newtonsoft.Json.Linq;
using System;
using System.IO;
using System.Net;

namespace CustomApplication
{
    public class AppMethods
    {
        public static string domain = "hhttps://www.saaspass.com/sd";
        public static string apiKey = "APIKEYGOESHERE";
        public static string apiPassword = "APIPASSSWORDGOESHERE";
        public static string companyKey = "COMPANYKEYGOESHERE";
        public static string companySecret = "COMPANYSECRETGOESHERE";

        private static string errMessage;
        public static string ErrMessage
        {
            get { return errMessage; }

            set{ errMessage = value; }
        }

        public AppMethods(){}

        public static string GetApplicationToken()
        {
            string urlForToken = domain + "/rest/applications/" + apiKey + "/tokens?password=" + apiPassword;
            return GetToken(urlForToken);

        }

        public static string GetCompanyToken()
        {
            string urlForCompanyToken = domain + "/rest/" + companyKey + "/tokens?companysecret=" + companySecret;
            return GetToken(urlForCompanyToken);
        }

        public static bool OTPCheck(string username, string otp, string apptoken)
        {
            string urlForOtp = domain + "/rest/applications/" + apiKey + "/otpchecks?username=" + username + "&otp=" + otp + "&token=" + apptoken;
            return CheckResponse(urlForOtp);

        }

        public static bool RegistrationByUser(string username, bool isadaccount, string saaspassid, string otp, string apptoken)
        {
            string urlForRegistrationByUser = domain + "/rest/applications/" + apiKey + "/registerbyuser?username=" + username + "&isadaccount=" + isadaccount + "&saaspassid=" + saaspassid + "&otp=" + otp + "&token=" + apptoken;
            return CheckResponse(urlForRegistrationByUser);
        }

        public static bool RegistrationByAdmin(string username, bool isadaccount, string accountowner, string apptoken)
        {
            string urlForRegistrationByAdmin = domain + "/rest/applications/" + apiKey + "/registerbyadmin?username=" + username + "&isadaccount=" + isadaccount + "&accountowner=" + accountowner + "&token=" + apptoken;
            return CheckResponse(urlForRegistrationByAdmin);
        }

        public static bool UnRegistration(string username, string apptoken)
        {
            string urlForRegistration = domain + "/rest/applications/" + apiKey + "/unregister?username=" + username + "&token=" + apptoken;
            return CheckResponse(urlForRegistration);
        }

        public static bool AddAccount(string username, string grouplist, string accountowner, string companytoken)
        {
            string urlForAddAcount = domain + "/rest/" + companyKey + "/addaccount?username=" + username + "&grouplist=" + grouplist + "&accountowner=" + accountowner + "&token=" + companytoken;
            return CheckResponse(urlForAddAcount);
        }

        public static bool VerifyAccount(string username, bool isadaccount, string accountowner, string companytoken)
        {
            string urlForVerifyAcount = domain + "/rest/" + companyKey + "/verifyaccount?username=" + username + "&isadaccount=" + isadaccount + "&accountowner=" + accountowner + "&token=" + companytoken;
            return CheckResponse(urlForVerifyAcount);

        }

        public static bool RemoveAccount(string username, string companyToken)
        {
            string urlForRemoveAcount = domain + "/rest/" + companyKey + "/removeaccount?username=" + username + "&token=" + companyToken;
            return CheckResponse(urlForRemoveAcount);

        }

        public static bool TrackerIdValidation(string username, string trackers, string appToken)
        {
            string urlForTracker = domain + "/rest/applications/" + apiKey + "/trackers/" + trackers + "?token=" + appToken + "&account=" + username;
            return CheckResponse(urlForTracker);
        }

        public static string GetToken(string url)
        {
            try
            {
                WebRequest request = WebRequest.Create(url);
                WebResponse response = request.GetResponse();
                StreamReader reader = new StreamReader(response.GetResponseStream());
                string tokenJsonString = reader.ReadToEnd();
                if (tokenJsonString != null)
                {
                    JToken tokenJtoken = JObject.Parse(tokenJsonString);
                    return (string)tokenJtoken.SelectToken("token");
                }
                else
                {
                    return null;
                }
            }
            catch (WebException e)
            {
                using (WebResponse response = e.Response)
                {
                    HttpWebResponse httpResponse = (HttpWebResponse)response;
                    if (httpResponse != null)
                    {
                        Console.WriteLine("Error code: {0}", httpResponse.StatusCode);
                        using (Stream data = response.GetResponseStream())
                        using (var reader = new StreamReader(data))
                        {
                            ErrMessage = reader.ReadToEnd();
                        }
                    }
                }
                return null;
            }

        }

        public static bool CheckResponse(string url)
        {
            try
            {
                WebRequest webRequest = WebRequest.Create(url);
                if (webRequest.GetResponse() != null)
                {
                    HttpWebResponse response = (HttpWebResponse)webRequest.GetResponse();
                    if (response.StatusCode == HttpStatusCode.OK)
                    {
                        if (response.GetResponseStream() != null)
                        {
                            StreamReader reader = new StreamReader(response.GetResponseStream());
                            string jsonString = reader.ReadToEnd();
                            if (jsonString != null && !jsonString.Equals(""))
                            {
                                JToken tokenJtoken = JObject.Parse(jsonString);
                                ErrMessage = tokenJtoken.SelectToken("resultMessage") != null ? (string)tokenJtoken.SelectToken("resultMessage") : "";
                                ErrMessage += tokenJtoken.SelectToken("warning") != null ? " - " + (string)tokenJtoken.SelectToken("warning") : "";
                            }
                        }

                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            catch (WebException e)
            {
                using (WebResponse response = e.Response)
                {
                    HttpWebResponse httpResponse = (HttpWebResponse)response;
                    if (httpResponse != null)
                    {
                        using (Stream data = response.GetResponseStream())
                        using (var reader = new StreamReader(data))
                        {
                            if (httpResponse.StatusCode.ToString()=="429")
                            {
                                ErrMessage = " X-Rate-Limit-Limit " + httpResponse.Headers["X-Rate-Limit-Limit"];
                                ErrMessage += " ### X-Rate-Limit-Remaining " + httpResponse.Headers["X-Rate-Limit-Remaining"];
                                ErrMessage += " ### X-Rate-Limit-Resets " + httpResponse.Headers["X-Rate-Limit-Resets"];
                            }
                            else
                            {
                                ErrMessage += reader.ReadToEnd();
                            }
                        }
                    }
                }
                return false;
            }
        }

        public static string GetBarcodeImage(string apptoken, string session, string type)
        {
            string urlForBarcode = domain + "/rest/applications/" + apiKey + "/barcodes?type=" + type + "&session=" + session + "&token=" + apptoken;

            try
            {
                WebRequest reqForBarcode = WebRequest.Create(urlForBarcode);
                WebResponse resForBarcode = reqForBarcode.GetResponse();
                StreamReader readBarcode = new StreamReader(resForBarcode.GetResponseStream());
                string barcodeJsonString = readBarcode.ReadToEnd();

                if (!barcodeJsonString.Equals(""))
                {
                    JToken barcodeJtoken = JObject.Parse(barcodeJsonString);
                    if (barcodeJtoken.SelectToken("bluetoothcode") != null)
                        return "saaspass://bluepass?" + (string)barcodeJtoken.SelectToken("bluetoothcode");
                    else
                        return "data:image/png;base64," + (string)barcodeJtoken.SelectToken("barcodeimage");
                }
                else
                    return null;
            }
            catch (WebException e)
            {
                using (WebResponse response = e.Response)
                {
                    HttpWebResponse httpResponse = (HttpWebResponse)response;
                    if (httpResponse != null)
                    {
                        using (Stream data = response.GetResponseStream())
                        using (var reader = new StreamReader(data))
                        {
                            ErrMessage = reader.ReadToEnd();
                        }
                    }
                }
                return null;
            }
        }

        public static bool PushLogin(string username, string session, string appToken)
        {
            string urlForPushLogin = domain + "/rest/applications/" + apiKey + "/push?username=" + username + "&session=" +session+ "&token=" + appToken;
            return CheckResponse(urlForPushLogin);
        }

    }
}