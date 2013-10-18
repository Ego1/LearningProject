package com.mockito.examples;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class GetterSetterMocking {
   @Mock
   SetGet setGet;
   String theString;

   @Before
   public void setup() {
      MockitoAnnotations.initMocks(this);

      Mockito.doAnswer(new Answer<Object>() {
         @Override
         public Object answer(InvocationOnMock invocation) throws Throwable {
            theString = (String) invocation.getArguments()[0];
            return null;
         }
      }).when(setGet).setString(Mockito.anyString());

      Mockito.when(setGet.getString()).thenAnswer(new Answer<String>() {
         @Override
         public String answer(InvocationOnMock invocation) throws Throwable {
            return theString;
         }
      });
   }

   @Test
   public void testname() throws Exception {
      setGet.setString("WOW");
      System.out.println(setGet.getString());

   }
}

interface SetGet {
   void setString(String newString);

   String getString();
}