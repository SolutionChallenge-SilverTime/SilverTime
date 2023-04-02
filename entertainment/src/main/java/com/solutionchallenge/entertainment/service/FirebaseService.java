package com.solutionchallenge.entertainment.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FirebaseService {
    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    public String uploadFiles(MultipartFile file) throws IOException, FirebaseAuthException {
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        // 업로드 할 파일 이름 생성
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
        return"https://storage.googleapis.com/" + bucket.getName() + "/" + blob.getName();
    }

//    public List<String> uploadMultiFiles(List<MultipartFile> files) throws IOException, FirebaseAuthException {
//        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
//        InputStream content = new ByteArrayInputStream(file.getBytes());
//        // 업로드 할 파일 이름 생성
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
//        return"https://storage.googleapis.com/" + bucket.getName() + "/" + blob.getName();
//    }
}
