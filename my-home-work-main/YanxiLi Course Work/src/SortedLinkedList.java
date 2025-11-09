import java.util.LinkedList;


public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {

    /**
     * Override super's method
     * @param element element whose presence in this collection is to be ensured
     * @return
     */
    @Override
    public boolean add(E element) {
        /**
         * If the list is empty,use super's method: add.
         *
         */
        if (isEmpty()) {
            return super.add(element);
        }

        /**
         * Locate the correct insertion position.
         *
         */
        for (int i = 0; i < size(); i++) {
            E current = get(i);

            /**
             * If current index larger than input index, put the index here.
             *
             */
            if (current.compareTo(element) > 0) {
                super.add(i, element);
                return true;
            }
        }


        return super.add(element);
    }


    @Override
    public void add(int index, E element) {

        add(element);
    }
}