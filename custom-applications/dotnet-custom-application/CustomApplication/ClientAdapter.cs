using System.Collections.Generic;

namespace CustomApplication
{
    /// This class is used to send events/messages to multiple clients.
    public class ClientAdapter
    {
        /// The recipient list.
        private Dictionary<string, Client> recipients = new Dictionary<string, Client>();

        /// Send a message to a particular recipient.
        public void SendMessage(Message message)
        {
            if (recipients.ContainsKey(message.reqSession))
            {
                Client client = recipients[message.reqSession];

                client.EnqueueMessage(message);
            }
        }
        /// Called by a individual recipient to wait and receive a message. <returns>The message content</returns>
        public string GetMessage(string session)
        {
            string username = string.Empty;

            if (recipients.ContainsKey(session))
            {
                Client client = recipients[session];

                username = client.DequeueMessage().reqUsername;
                string a = username;
            }

            return username;
        }
        /// Join a user to the recipient list.
        public void Join(string session)
        {
            recipients[session] = new Client();
        }
        public static ClientAdapter Instance = new ClientAdapter();
        private ClientAdapter() { }
    }
}