package study_alone;
import java.util.*;
import java.io.*;

/*
과제 진행하기 (레벨2)
스택 자료구조.
https://school.programmers.co.kr/learn/courses/30/lessons/176962#
 */
public class P_176962 {

    static class Homework {
        String name;
        int hour, min, add;
        int stTime = 0;
        int endTime = 0;
        public void addTime(int add) {
            int hourEnd = this.endTime / 100;
            int minEnd = this.endTime % 100;
            hourEnd += (minEnd + add) / 60;
            minEnd = (minEnd + add) % 60;
            this.endTime = hourEnd * 100 + minEnd;
        }

        Homework(String name, int hour, int min, String add) {
            this.name = name;
            this.hour = hour;
            this.min = min;
            this.add = Integer.parseInt(add);

            this.stTime = hour * 100 + min;

            int minAdd = min + this.add;
            int hourAdd = hour;
            if (minAdd >= 60) {
                minAdd %= 60;
                hourAdd += ((min + this.add) / 60);
            }

            this.endTime = hourAdd * 100 + minAdd;
        }
    }
    public Homework getHomework(String[] plan) {
        String[] times = plan[1].split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);

        return new Homework(plan[0], hour, min, plan[2]);
    }
    public String[] solution(String[][] plans) {
        Stack<Homework> stack = new Stack<>();
        Arrays.sort(plans, (o1,o2) -> {
            return o1[1].compareTo(o2[1]);
        });

        String[] answer = new String[plans.length];
        int k = 0;

        for (int i = 0; i < plans.length; i++) {

            if (stack.isEmpty()) {
                stack.push(getHomework(plans[i]));
            } else {
                Homework before = stack.peek();
                Homework newWork = getHomework(plans[i]);
                int add = before.add;

                while (before.endTime <= newWork.stTime) {
                    Homework tmp = stack.pop();
                    answer[k++] = tmp.name;
                    if (stack.isEmpty()) break;
                    before = stack.peek();

                    //before의 끝나는 시간 갱신해야함.
                    //기존 끝나던 시간에서 + newWork.add

                    before.addTime(add);
                    System.out.println(before.name + " " + before.endTime);
                    add += before.add;
                }
                stack.push(newWork);
            }
        }

        while (!stack.isEmpty()) {
            answer[k++] = stack.pop().name;
        }

        return answer;
    }
}
