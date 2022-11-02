Feature: Files features
  As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.

  Background:
    Given the user is on the login page
    And the user enters the files menu
@ETSKY-852
Scenario: Adding files to favorites verification
  When user click three dots of the created file
  And user select add to favorites link
  Then user should see selected file has a star icon
@ETSKY-853
Scenario: Renaming file verification
  When user click three dots of the created file
  And user select rename and write new name and click enter
  Then user should see new name on the file
@ETSKY-854
Scenario: Renaming file with existing name verification
  When user click three dots of the created file
  And user select rename and write already existing file name and click enter
  Then user should not able to rename with existing file name
@ETSKY-855
Scenario: Making comment verification
  When user click on three dots and select details option
  And  user select comments button and type a comment in comment box then click enter
  Then user should see the comment is published
@ETSKY-856
Scenario: Deleting comment verification
  When user click on three dots and select details option
  And user click three dots of any comment and select delete
  Then user should see that comment is deleted




