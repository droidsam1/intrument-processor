# [Instrument Processor Kata](https://www.planetgeek.ch/2010/03/28/mocking-kata-instrument-processor-net/)

* This is part of my practice of exercises provided by the book _Agile Technical Practices Distilled_

In the Instrument Processor Kata, we are going to implement a class that gets tasks from a TaskDispatcher and executes them on an Instrument.

![clas diagram](https://www.planetgeek.ch/wp-content/uploads/2010/03/ClassDiagram_thumb.png )

The InstrumentProcessor – the class to develop– has to implement the following interface.

    public interface IInstrumentProcessor
    {
        void Process();
    }

The dependencies that the InstrumentProcessor can use to do its job are a task dispatcher with the following interface:

    public interface ITaskDispatcher
    {
        string GetTask();
        void FinishedTask(string task);
    }

The GetTask method returns the next task to execute on the instrument.

After the task was successfully executed on the instrument, the FinishedTask method has to be called by the InstrumentProcessor passing the task that was completed as the method argument.

The second dependency of the InstrumentProcessor is an instrument with the following interface:

    public interface IInstrument
    {
        void Execute(string task);
        event EventHandler Finished;
        event EventHandler Error;
    }

The Execute method starts the instrument, which will begin to execute the task passed to it. The method will return immediately (we assume that the instrument implementation is asynchronous).
The Execute method will throw an ArgumentNullException if the task passed in is null.

When the instrument finished executing then the Finished event is fired.

When the instrument detects an error situation during executing (note that the Execute method will already have returned the control flow to the caller due to its asynchronous implementation) then it fires the Error event.

The exercise is to implement the InstrumentProcessor in a way that

* when the method Process is called then the InstrumentProcessor gets the next task from the task dispatcher and executes it on the instrument.
* when the Execute method of the instrument throws an exception then this exception is passed on to the caller of the Process method.
* when the instrument fires the Finished event then the InstrumentProcessor calls the task dispatcher’s FinishedTask method with the correct task.
* when the instrument fires the Error event then the InstrumentProcessor writes the string “Error occurred” to the console.



## POINTS OF INTEREST
The following points make this exercise interesting:

* Helps clarify differences between Stubs (provider) and Mocks (expected calls).
* Because the Finished method does not return the finished task, the processor has to store it in its own state. Therefore, whole feature tests instead of single method tests are enforced on the trainee.
* Writing to the console has to be mocked, too. Otherwise, the error message cannot be asserted.
* Different stub/mock behaviors (methods, event and exceptions) are used.

Happy mocking!<br>