package com.labbackend.labbackendx.controller;

import com.labbackend.labbackendx.model.Member;
import com.labbackend.labbackendx.model.team.Team;
import com.labbackend.labbackendx.repository.MemberRepository;
import com.labbackend.labbackendx.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @PostMapping
    public Member addMember(@RequestBody MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setKeyword(memberDTO.getKeyword());
        member.setDoctorant(memberDTO.isDoctorant());

        if (memberDTO.getTeamId() != null) {
            Optional<Team> teamOptional = teamRepository.findById(memberDTO.getTeamId());
            teamOptional.ifPresent(member::setTeam);
        }

        return memberRepository.save(member);
    }

    @GetMapping
    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public static class MemberDTO {
        private String name;
        private String keyword;
        private boolean isDoctorant;
        private Long teamId;

        public MemberDTO() {
            // Default constructor
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public boolean isDoctorant() {
            return isDoctorant;
        }

        public void setDoctorant(boolean doctorant) {
            isDoctorant = doctorant;
        }

        public Long getTeamId() {
            return teamId;
        }

        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }
    }
}