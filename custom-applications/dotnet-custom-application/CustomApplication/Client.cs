using System.Collections.Generic;
using System.Threading;

namespace CustomApplication
{
    public class Client
    {
        private ManualResetEvent messageEvent = new ManualResetEvent(false);
        private Queue<Message> messageQueue = new Queue<Message>();

        /// This method is called by a sender to send a message to this client.
        public void EnqueueMessage(Message message)
        {
            lock (messageQueue)
            {
                messageQueue.Enqueue(message);

                // Set a new message event.
                messageEvent.Set();
            }
        }
        /// This method is called by the client to receive messages from the message queue.
        /// If no message, it will wait until a new message is inserted. <returns>the unread message</returns>
        public Message DequeueMessage()
        {
            // Wait until a new message.
            messageEvent.WaitOne();
            lock (messageQueue)
            {
                if (messageQueue.Count == 1)
                {
                    messageEvent.Reset();
                }
                return messageQueue.Dequeue();
            }
        }
    }
}