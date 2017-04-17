package DAO;

import entities.*;
import persistance.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentDao {
    public void createComment(Comment comment){
        PersistenceUtil.persist(comment);
    }

    public static List<Comment> findAllComments() {
        EntityManager em = persistance.PersistenceUtil.createEM();
        List<Comment> comments = (List<Comment>)
                em.createNamedQuery("comment.findAll").getResultList();
        em.close();

        return comments;
    }
}