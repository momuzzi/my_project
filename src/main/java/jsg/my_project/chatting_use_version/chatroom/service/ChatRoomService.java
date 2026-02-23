package jsg.my_project.chatting_use_version.chatroom.service;

import java.util.Optional;
import jsg.my_project.chatting_use_version.chatroom.converter.ChatRoomMemberConverter;
import jsg.my_project.global.response.code.status.ErrorStatus;
import jsg.my_project.global.response.exception.GeneralException;
import jsg.my_project.mts.member.Member;
import jsg.my_project.mts.member.repository.MemberRepository;
import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import jsg.my_project.chatting_use_version.chatroom.ChatRoomMember;
import jsg.my_project.chatting_use_version.chatroom.dto.EnterChatRoomRequest;
import jsg.my_project.chatting_use_version.chatroom.repository.ChatRoomMemberRepository;
import jsg.my_project.chatting_use_version.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;

    @Transactional
//    @Retryable(
//        retryFor = ObjectOptimisticLockingFailureException.class,
//        maxAttempts = 10,
//        backoff = @Backoff(delay = 100, multiplier = 1.5, maxDelay = 1000)
//    )
    public void enterChatRoom(EnterChatRoomRequest request) {
        Member member = memberRepository.findById(request.memberId())
            .orElseThrow(
                () -> new GeneralException(ErrorStatus._MEMBER_NOT_FOUND)
            );

        ChatRoom chatRoom = chatRoomRepository.findByIdWithLock(request.chatRoomId())
                .orElseThrow(
                    () -> new GeneralException(ErrorStatus._CHATROOM_NOT_FOUND)
                );

        Optional<ChatRoomMember> findChatRoomMember = chatRoomMemberRepository.findByMemberAndChatRoomId(
            member, chatRoom.getId());

        if (findChatRoomMember.isPresent()) { // 이미 해당방 들어간 적이 있으면
            // return 채팅방의 최신 채팅 내역
        } else { //
            ChatRoomMember chatRoomMember = ChatRoomMemberConverter.toEntity(chatRoom, member);

            chatRoom.updateParticipantNum();
//            chatRoomRepository.updateAtomicParticipantNum(chatRoom.getId());

            chatRoomMemberRepository.save(chatRoomMember);
        }

    }
}
