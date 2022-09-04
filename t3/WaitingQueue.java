class WaitingQueue {
    public String[] waitingHere; 
    public int front; // "Leave a gap" when array is full
    public int back; // back is the index AFTER last element

    public static final int ARR_LENGTH = 10;

    public WaitingQueue() {
        waitingHere = new String[ARR_LENGTH];
    }

    public boolean isEmpty() {
        return front == back;
    }

    // Returns true if Person is successfully added
    public boolean addAPerson(String newPerson) {
        if ((back + 1) % ARR_LENGTH == front) // array full
            return false;
        waitingHere[back] = newPerson;
        back = (back + 1) % ARR_LENGTH; // circular array behavior
        return true;
    }

    public String serveNextPerson() {
        if (isEmpty()) // empty queue
            return null;
        String firstPerson = waitingHere[front];
        waitingHere[front] = null; // optional
        front = (front + 1) % ARR_LENGTH;
        return firstPerson;
    }

    // Returns true if someone is removed from the queue
    public boolean leave(String personName) {
    
        // find first matching person
        boolean found = false;
        int position = front;
        while (position != back) { // pos may NOT be < back !!!
            if (waitingHere[position].equals(personName)) {
                waitingHere[position] = null; // optional
                found = true;
                break;
            }
            position = (position + 1) % ARR_LENGTH;
        }
    
        if (!found)
            return false;
    
        // left shift elements
        position = (position + 1) % ARR_LENGTH;
        while (position != back) {
            if (position != 0)
                waitingHere[position-1] = waitingHere[position];
            else
                waitingHere[ARR_LENGTH - 1] = waitingHere[0];
            position = (position + 1) % ARR_LENGTH;
        }
    
        // decrement back
        back = (back + ARR_LENGTH - 1) % ARR_LENGTH;
        return true;
    }
}