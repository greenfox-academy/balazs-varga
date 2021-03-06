import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TodoList {

  private final String TASK_COMPLETED_SYMBOL = "[X]";
  private final String TASK_INCOMPLETED_SYMBOL = "[ ]";
  private List<String> todosString;
  private String name;
  private List<Todo> todos;
  private int idToComplete;
  private List<String> idList;
  private int idCount = 0;
  private FileManipulation fileManipulation;

  public TodoList(String name) {
    this.name = name;
    todosString = new ArrayList<>();
    fileManipulation = new FileManipulation();
  }

  public void listTasks() {
    todos = fileManipulation.readAllDataFromFile();
    if (todos.size() > 0) {
      for (Todo todo : todos) {
        if (todo.isCompleted()) {
          System.out.println((todo.getId()) + " - " + TASK_COMPLETED_SYMBOL + " " + todo.toString() + " - Task is completed in: "
                  + todo.completionTime() + " day(s)");
        } else {
          System.out.println((todo.getId()) + " - " + TASK_INCOMPLETED_SYMBOL + " " + todo.toString());
        }
      }
    } else {
      System.out.println("No todos for today! :)");
    }
  }

  public void completeTask(String idString) {
    todos = fileManipulation.readAllDataFromFile();
    idToComplete = Integer.parseInt(idString);
    List<Integer> ids = getIdsOfTodoList();
    if (!ids.contains(idToComplete)) {
      System.out.println("Unable to check: the id doesn't exist");
      return;
    } else {
      todos.stream()
              .filter(todo -> todo.getId() == idToComplete)
              .forEach(todo -> {
                todo.setCompleted(true);
                todo.setCompletedAt(LocalDateTime.now());
      });
      fileManipulation.writeTasksToFile(todos);
    }
  }

  public void removeTask(String idString) {
    todos = fileManipulation.readAllDataFromFile();
    int idToRemove = Integer.parseInt(idString);
    List<Integer> ids = getIdsOfTodoList();
    if (!ids.contains(idToRemove)) {
      System.out.println("Unable to remove: id is out of bound");
      return;
    } else {
      for (int i = 0; i < todos.size(); i++) {
        if (todos.get(i).getId() == idToRemove) {
          todos.remove(i);
        }
      }
    }
    fileManipulation.writeTasksToFile(todos);
  }

  public void addNewTask(String args) {
    todos = fileManipulation.readAllDataFromFile();
    idList = fileManipulation.readIDFromFile();
    idCount = Integer.parseInt(idList.get(0));
    idCount++;
    idList.add(0, "" + idCount);
    fileManipulation.writeIDToFile(idList);
    Todo newTodo = new Todo(args);
    newTodo.setId(idCount);
    newTodo.setCreatedAt(LocalDateTime.now());
    todos.add(newTodo);
    fileManipulation.writeTasksToFile(todos);
  }

  public void updateTask(String idString, String taskName) {
    todos = fileManipulation.readAllDataFromFile();
    int idToUpdate = Integer.parseInt(idString);
    List<Integer> ids = getIdsOfTodoList();
    if (!ids.contains(idToUpdate)) {
      System.out.println("Unable to update: id is out of bound");
      return;
    } else {
      IntStream.range(0, todos.size())
              .filter(i -> todos.get(i).getId() == idToUpdate)
              .forEach(i -> todos.get(i).setName(taskName));
    }
    fileManipulation.writeTasksToFile(todos);
  }

  private List<Integer> getIdsOfTodoList() {
    List<Integer> ids = new ArrayList<>();
    todos.forEach(todo -> ids.add(todo.getId()));
    return ids;
  }
}
