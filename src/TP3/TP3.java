package TP3;
import java.util.List;

public class TP3 {
    public int recursiveIndexOf(String target, List<String> list) {
        return recursiveIndexOfByIndex(target, list, 0);
    }

    public int recursiveIndexOfByIndex(String target, List<String> list, int index) {
        index += 1;
        if (list.get(index) == target) {
            return index;
        }
        if (list.size() == index) {
            return -1;
        } else {
            return recursiveIndexOfByIndex(target, list, index + 1);
        }
    }

    public int recursiveIndexOfEmptyHelper(List<String> list, int index) {
        index += 1;
        if (list.get(index) == "") {
            return index;
        }
        if (list.size() == index) {
            return -1;
        } else {
            return recursiveIndexOfEmptyHelper(list, index + 1);
        }
    }
    public int recursiveIndexOfEmpty(List<String> list){
        return recursiveIndexOfEmptyHelper(list, 0);
    }
}
