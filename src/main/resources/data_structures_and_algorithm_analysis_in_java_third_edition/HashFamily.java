package data_structures_and_algorithm_analysis_in_java_third_edition;

public interface HashFamily<AnyType>
{
    int hash(AnyType x, int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}
