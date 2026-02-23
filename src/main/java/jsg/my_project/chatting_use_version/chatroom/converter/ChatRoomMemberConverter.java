package jsg.my_project.chatting_use_version.chatroom.converter;

import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import jsg.my_project.chatting_use_version.chatroom.ChatRoomMember;
import jsg.my_project.mts.member.Member;

public class ChatRoomMemberConverter {


    public static ChatRoomMember toEntity(ChatRoom chatRoom, Member member) {
        return ChatRoomMember.builder()
            .chatRoomId(chatRoom.getId())
            .member(member)
            .isNotificationEnabled(true)
            .build();
    }
}
