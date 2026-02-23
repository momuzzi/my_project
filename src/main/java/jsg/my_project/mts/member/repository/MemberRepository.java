package jsg.my_project.mts.member.repository;

import jsg.my_project.mts.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
