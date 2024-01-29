public class StoryHander {
    private int index = 0;
    private String part1 = "Congratulations! You’ve arrived on Anen Island, an island where a volcano had erupted centuries ago, killing off the inhabitants. You are an Archaeologist with a special interest in linguistics, and you have arrived to study the ruins of the Anen people. You take a look around the docks you have arrived on, the ferryman who took you here already boating off back to the mainland. The island is very tropical, with palm trees swaying in a gentle breeze. Do you want to head towards the remains of a library, half-covered in sand, a house that is mostly upright, or a pier dotted with ashes and volcanic rock?";
    private String[] storyParts = {part1};

    public String getNext(){
        return storyParts[index++];
    }
}
