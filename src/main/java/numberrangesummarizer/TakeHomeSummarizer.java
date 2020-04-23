package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


class TakeHomeSummerizer implements NumberRangeSummarizer {
    
    //collect the input
    public Collection<Integer> collect(String input) {

        // empty case
        if (input.isEmpty()){
            return new ArrayList<>();
        } else {
            // split to String[] and stream
            return Arrays.stream(input.split(","))
                //map to String -> in
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }
    }

    //get the summarized string
    public String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> inputList = (ArrayList<Integer>) input;
        String groupedRange = "";

        for(int i = 0 ; i < inputList.size() - 1; i++){

            int currentItem = inputList.get(i);

            boolean sequenceWithNext = inputList.get(i + 1) - currentItem == 1;
            boolean sequenceWithPrev = (i == 0) ? false : currentItem - inputList.get(i - 1) == 1;

            if (sequenceWithNext && !sequenceWithPrev)  groupedRange += currentItem + "-";
            if (!sequenceWithNext)  groupedRange += currentItem + ", ";
        }

        if(inputList.size() != 0) groupedRange += inputList.get(inputList.size() - 1);

        return groupedRange;
    }


}