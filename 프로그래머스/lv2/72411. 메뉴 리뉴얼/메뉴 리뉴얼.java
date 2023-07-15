import java.util.*;
import java.util.stream.*;

class Solution {
    static class Course{
        String menus;
        int cnt;
        
        Course(String menus, int cnt){
            this.menus = menus;
            this.cnt = cnt;
        }
    }
    
    Set<String> selectedMenus;
    List<Set<String>> orderList;
    Map<Integer, List<Course>> courses;
    
    void getCourses(char nextMenu){
        int cnt = (int) orderList.stream()
            .filter(order -> order.containsAll(selectedMenus))
            .count();
        if (cnt < 2)
            return;
        
        int size = selectedMenus.size();
        if (courses.containsKey(size)){
            List<Course> courseList = courses.get(size);
            Course course = new Course(selectedMenus.stream().sorted().collect(Collectors.joining()), cnt);
            Course original = courseList.get(0);
            if (original.cnt < cnt){
                courseList.clear();
                courseList.add(course);
            }
            else if (original.cnt == cnt){
                courseList.add(course);
            }
        }
        
        if(size >= 10)
            return;
        for (char i = nextMenu; i <= 'Z'; i++)
        {
            String menu = String.valueOf(i);
            selectedMenus.add(menu);
            getCourses((char)(i + 1));
            selectedMenus.remove(menu);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        orderList = Arrays.stream(orders)
            .map(String::chars)
            .map(stream -> stream
                 .mapToObj(menu -> String.valueOf((char) menu))
                 .collect(Collectors.toSet()))
            .collect(Collectors.toList());
        
        courses = new HashMap<>();
        for (int length : course){
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }
        selectedMenus = new HashSet<>();
        getCourses('A');
        
        return courses.values().stream()
            .filter(list -> list.get(0).cnt > 0)
            .flatMap(List::stream)  //내부스트림을 외부스트림과 합쳐 하나의 스트림으로 만든다(?)
            .map(c -> c.menus)
            .sorted()
            .toArray(String[]::new);
    }
}