$(document).ready(function () {
    var id = 0;

    axios.get("/api/chat/lastid").then(function (res) {
        id = res.data.data
        console.log(id)
        updateChat(id)
    })

    $('.btn-show-message').on('click',function () {
        var chat = $(this).parent().children("#messageArea").children('.inner-chat').children(".chat-message")
        var lastMessageId = chat.children('.user-name').data('id')
        console.log(chat)
        updateChat(lastMessageId)
    })

    function updateChat(lastMessageId) {
        axios.get("/api/chat/getchat/"+lastMessageId).then(function (res) {
            var inner_chat = document.createElement("div")
            inner_chat.classList.add("inner-chat")
            if(res.data.success){
                for(var message of res.data.data){
                    var messageElement = document.createElement('li');
                    messageElement.classList.add('chat-message');
                    var avatarElement = document.createElement('i');
                    var avatarText = document.createTextNode(message.username[0]);
                    avatarElement.appendChild(avatarText);
                    avatarElement.style['background-color'] = getAvatarColor(message.username);

                    messageElement.appendChild(avatarElement);

                    var usernameElement = document.createElement('span');
                    usernameElement.classList.add('user-name')
                    usernameElement.setAttribute("data-id", message.id)
                    var usernameText = document.createTextNode(message.username);
                    usernameElement.appendChild(usernameText);
                    messageElement.appendChild(usernameElement);


                    var textElement = document.createElement('p');
                    textElement.classList.add("message-content")
                    var spanDate = document.createElement('span')
                    spanDate.classList.add('message-date')
                    var newDate = message.date.split(" ")
                    spanDate.appendChild(document.createTextNode(newDate[0] +" lúc "+ newDate[1]))
                    var messageText = document.createTextNode(message.content);
                    textElement.appendChild(messageText);
                    textElement.appendChild(spanDate)

                    messageElement.appendChild(textElement);
                    inner_chat.append(messageElement)
                    messageArea.scrollTop = 0;
                }
                $('#messageArea').prepend(inner_chat);
            }
        })
    }
})