public class Candidate implements CampaignActions, Comparable {

  // private instance variables
  private String _firstName, _lastName;
  private int _funds;
  private double _supportPercentage;

  // constructor
  public void Candidate(String first, String last) {
    _firstName = first;
    _lastName = last;
    _funds = 10000000;
    _supportPercentage = 30.0;
  }

  // Postcondition: _funds decrease and supportPercentage increase
  // O(1)
  public void attackAd (int money) {
    _funds -= money;
    _supportPercentage += 1.2 * money/500000;
  }

  // Postcondition: _funds decrease and supportPercentage increase
  // O(1)
  public void hireStaff () {
    _funds -= 500000;
    _supportPercentage += 1;
  }

  // Postcondition: _funds decrease and supportPercentage increase
  // O(1)
  public void holdRally (int money) {
    _funds -= money;
    _supportPercentage += 1.4 * money/450000;
  }

  // Postcondition: _funds decrease and supportPercentage increase
  // O(1)
  public void straightTalk (int money) {
    _funds -= money;
    _supportPercentage += 1.7 * money/375000;
  }

  // O(1)
  public int getFunds() {
    return _funds;
  }

  // O(1)
  public double getSupport () {
    return _supportPercentage;
  }

  // O(1)
  public int compareTo(Object other) {
    return (int) getSupport() - (int) (((Candidate)other).getSupport());
  }

}
