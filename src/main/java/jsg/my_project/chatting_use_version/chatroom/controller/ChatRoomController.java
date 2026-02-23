package jsg.my_project.chatting_use_version.chatroom.controller;

import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import jsg.my_project.chatting_use_version.chatroom.dto.EnterChatRoomRequest;
import jsg.my_project.chatting_use_version.chatroom.repository.ChatRoomRepository;
import jsg.my_project.chatting_use_version.chatroom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatRoomRepository chatRoomRepository;

    @PostMapping("/{chatroomId}")
    public void enterChatRoom(@RequestBody EnterChatRoomRequest request) {
        chatRoomService.enterChatRoom(request);
    }

    @PostMapping("/chatroom-make")
    public void makeChatRoom() {
        ChatRoom chatroom = ChatRoom.builder()
            .name("스테파노관")
            .participantNum(0)
            .build();

        chatRoomRepository.save(chatroom);
    }
}
