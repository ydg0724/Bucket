package com.bucket.backend.service;

import com.bucket.backend.model.UserVideo;
import com.bucket.backend.model.users;
import com.bucket.backend.repository.UserRepository;
import com.bucket.backend.repository.UserVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserVideoService {

    private final UserVideoRepository userVideoRepository;
    private final UserRepository userRepository;

    //운동 영상 저장
    public UserVideo saveUserVideo(UserVideo userVideo, String videoUrl) {
        // 유저 확인 예외 처리
        if(!userRepository.existsById(userVideo.getUser().getUid())){
            throw new IllegalArgumentException("유저를 찾지 못했습니다.");
        }
        
        try{

            //업로드된 S3 URL 엔티티에 수정
            userVideo.setVideoUrl(videoUrl);

            //DB에 저장
            return userVideoRepository.save(userVideo);
        } catch (Exception e) {
            throw new RuntimeException("파일 업로드 중 오류 발생" + e.getMessage());
        }
    }

    // 사용자별 운동 기록 조회
    public List<UserVideo> getVideoByUid(users uid) {
        return userVideoRepository.findByUser(uid);
    }

    //운동 기록 상세 조회
    public Optional<UserVideo> getUserVideoDetail(int vid) {
        return userVideoRepository.findById(vid);
    }
    // Optimal : NPE(NullPointerException)을 방지하게 도와주는 Wrapper 클래스 -> 참조하더라도 NPE가 발생하지 않도록 도와준다.

    //운동 기록 삭제
    public void deleteUserVideo(int vid){
        Optional<UserVideo> userVideo = userVideoRepository.findById(vid);
        if(userVideo.isPresent()){
            userVideoRepository.deleteById(vid);
        } else {
            throw new IllegalArgumentException(vid+"의 vid를 찾을 수 없습니다.");
        }
    }
    //운동 기록 수정
    public UserVideo updateUserVideo(int vid, UserVideo userVideo) {
        Optional<UserVideo> updateVideo = userVideoRepository.findById(vid);
        if(updateVideo.isPresent()){
            updateVideo.get().setFeedback(userVideo.getFeedback());
            updateVideo.get().setSportname(userVideo.getSportname());
            updateVideo.get().setRecordDate(userVideo.getRecordDate());
            updateVideo.get().setVideoUrl(userVideo.getVideoUrl());
        } else {
            throw new IllegalArgumentException(vid+"의 vid를 찾을 수 없습니다.");
        }
        return userVideoRepository.save(updateVideo.get());
    }

}
