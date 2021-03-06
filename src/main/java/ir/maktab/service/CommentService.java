package ir.maktab.service;

import ir.maktab.dto.CommentDto;
import ir.maktab.service.exception.NotFoundOrderException;

import java.util.List;

public interface CommentService {
    void saveNewComment(CommentDto dto) throws NotFoundOrderException;

    void deleteComment(CommentDto dto);

    void updateComment(CommentDto dto);

    List<CommentDto> fetchAllComments();

}
