package com.example.demo.service;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionExample;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {

        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        size = size < 1 ? 1 : size;
        Integer totalPage;
        if (totalCount % size == 0 && totalCount > 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        page = page < 1 ? 1 : (page > totalPage ? totalPage : page);

        Integer offset = size * (page - 1);

        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));

        //List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            UserExample example = new UserExample();
            example.createCriteria()
                    .andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(example);
            //User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(totalPage, page, size);

        return paginationDTO;
    }

    public PaginationDTO list(String userAccountId, Integer page, Integer size) {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userAccountId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample);
        //Integer totalCount = questionMapper.countByUserId(userAccountId);
        size = size < 1 ? 1 : size;
        Integer totalPage;
        if (totalCount % size == 0 && totalCount > 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        page = page < 1 ? 1 : (page > totalPage ? totalPage : page);

        Integer offset = size * (page - 1);

        questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userAccountId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset, size));
        //List<Question> questions = questionMapper.listByUserId(userAccountId, offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            UserExample example = new UserExample();
            example.createCriteria()
                    .andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(example);
            //User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(totalPage, page, size);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(id);
        List<Question> questions = questionMapper.selectByExample(questionExample);
        Question question = questions.get(0);
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountIdEqualTo(question.getCreator());
        List<User> users = userMapper.selectByExample(example);
        //User user = userMapper.findById(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setUser(users.get(0));
        BeanUtils.copyProperties(question, questionDTO);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        //Question dbQuestion = questionMapper.findById(question.getId());
        if (question.getId() == null) {
            questionMapper.insert(question);
        } else {
            Question updateQuestion = new Question();
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            updateQuestion.setGmtModified(System.currentTimeMillis());
            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
            questionMapper.updateByExampleSelective(updateQuestion, example);
            //questionMapper.update(question);
        }
    }
}
