using System.Web.Services;

namespace CustomApplication
{
    /// This web service contains methods that help dispatching events to the client.
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    [System.Web.Script.Services.ScriptService]
    public class Dispatcher : System.Web.Services.WebService
    {
        /// Dispatch the new message event.
        /// <param name="userName">The loged in user name</param> <returns>the message content</returns>
        [WebMethod]
        public string WaitMessage(string session)
        {
            return ClientAdapter.Instance.GetMessage(session);
        }
    }
}
