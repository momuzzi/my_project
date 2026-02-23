package jsg.my_project.chatting_use_version.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jsg.my_project.global.util.BaseTime;
import jsg.my_project.mts.member.Member;
import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Chat extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatRoom;      // 채팅방

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;    // 채팅 보낸 사람

    private String content;     // 채팅 내용
}
