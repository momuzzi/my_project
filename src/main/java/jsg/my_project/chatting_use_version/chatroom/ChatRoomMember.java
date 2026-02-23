package jsg.my_project.chatting_use_version.chatroom;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jsg.my_project.global.util.BaseTime;
import jsg.my_project.mts.member.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class ChatRoomMember extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private ChatRoom chatRoom;

    private Long chatRoomId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private boolean isNotificationEnabled;

    public void updateNotificationEnabled(boolean notificationEnabled) {
        this.isNotificationEnabled = notificationEnabled;
    }
}
