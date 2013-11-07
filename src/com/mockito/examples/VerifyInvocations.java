package com.mockito.examples;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Check http://mockito.googlecode.com/svn/branches/1.6/javadoc/org/mockito/Mockito.html
 */
public class VerifyInvocations {
   @Mock
   private List<String> mockedList;

   @Before
   public void start() {
      initMocks(this);
   }

   @Test
   public void isAddInvoked() {
      mockedList.add("a");
      mockedList.add("b");
      mockedList.add("b");

      // Verify that the add method has been invoked
      verify(mockedList, times(1)).add("a");
      verify(mockedList).add("a"); // times(1) is default
      verify(mockedList, times(2)).add("b");
      verify(mockedList, never()).add("never happened");

      // verification using atLeast()/atMost()
      verify(mockedList, atLeastOnce()).add("b");
      verify(mockedList, atLeast(2)).add("b");
      verify(mockedList, atMost(2)).add("a");
   }
}
