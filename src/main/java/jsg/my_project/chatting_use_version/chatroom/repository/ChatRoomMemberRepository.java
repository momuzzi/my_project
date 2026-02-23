package jsg.my_project.chatting_use_version.chatroom.repository;

import java.util.Optional;
import jsg.my_project.mts.member.Member;
import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import jsg.my_project.chatting_use_version.chatroom.ChatRoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long> {

    Optional<ChatRoomMember> findByMemberAndChatRoomId(Member member, Long chatRoomId);
}
