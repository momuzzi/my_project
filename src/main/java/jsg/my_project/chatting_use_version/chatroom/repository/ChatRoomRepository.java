package jsg.my_project.chatting_use_version.chatroom.repository;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import jsg.my_project.chatting_use_version.chatroom.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Modifying
    @Query("""
        update ChatRoom c
        set c.participantNum = c.participantNum + 1
        where c.id = :id
    """)
    void updateAtomicParticipantNum(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select cr from ChatRoom cr where cr.id = :id")
    Optional<ChatRoom> findByIdWithLock(Long id);
}
