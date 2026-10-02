package com.example.ToDo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDo> getToDo(){
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(Long id){
            return toDoRepository.findById(id).orElseThrow(()->
                    new RuntimeException("Unnable to find Expense with id:- "+id));
    }

    public ToDo addToDo(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id) {
        getToDoById(id);
        toDoRepository.deleteById(id);
    }
        public ToDo updateToDo(ToDo toDo){
      getToDoById(toDo.getId());
      return toDoRepository.save(toDo);

    }
}
