/*
 * Copyright (C) 2012 Android Shuffle Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dodgybits.shuffle.sync.model;

public class TaskChangeSet extends EntityChangeSet {

    private static final long DESCRIPTION_MASK = 0b100;
    private static final long DETAILS_MASK = 0b1000;
    private static final long CONTEXTS_MASK = 0b1_0000;
    private static final long PROJECT_MASK = 0b10_0000;
    private static final long SHOW_FROM_MASK = 0b100_0000;
    private static final long DUE_MASK = 0b1000_0000;
    private static final long ALL_DAY_MASK = 0b1_0000_0000;
    private static final long ORDER_MASK = 0b10_0000_0000;
    private static final long COMPLETE_MASK = 0b100_0000_0000;

    public static TaskChangeSet newChangeSet() {
        return new TaskChangeSet(NO_CHANGES);
    }


    public static TaskChangeSet fromChangeSet(long changeSet) {
        return new TaskChangeSet(changeSet);
    }

    private TaskChangeSet(long changeSet) {
        super(changeSet);
    }

    public boolean isDescriptionChanged() {
        return changed(DESCRIPTION_MASK);
    }

    public boolean descriptionChanged() {
        return mark(DESCRIPTION_MASK);
    }

    public boolean isDetailsChanged() {
        return changed(DETAILS_MASK);
    }

    public boolean detailsChanged() {
        return mark(DETAILS_MASK);
    }

    public boolean isContextsChanged() {
        return changed(CONTEXTS_MASK);
    }

    public boolean contextsChanged() {
        return mark(CONTEXTS_MASK);
    }

    public boolean isProjectChanged() {
        return changed(PROJECT_MASK);
    }

    public boolean projectChanged() {
        return mark(PROJECT_MASK);
    }

    public boolean isShowFromChanged() {
        return changed(SHOW_FROM_MASK);
    }

    public boolean showFromChanged() {
        return mark(SHOW_FROM_MASK);
    }

    public boolean isDueChanged() {
        return changed(DUE_MASK);
    }

    public boolean dueChanged() {
        return mark(DUE_MASK);
    }

    public boolean isAllDayChanged() {
        return changed(ALL_DAY_MASK);
    }

    public boolean allDayChanged() {
        return mark(ALL_DAY_MASK);
    }

    public boolean isCompleteChanged() {
        return changed(COMPLETE_MASK);
    }

    public boolean completeChanged() {
        return mark(COMPLETE_MASK);
    }

    public boolean isOrderChanged() {
        return changed(ORDER_MASK);
    }

    public boolean orderChanged() {
        return mark(ORDER_MASK);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[TaskChangeSet");
        if (hasChanges()) {
            builder.append(" changed:");
            if (isActiveChanged()) {
                builder.append(" active");
            }
            if (isDeletedChanged()) {
                builder.append(" deleted");
            }
            if (isDescriptionChanged()) {
                builder.append(" description");
            }
            if (isDetailsChanged()) {
                builder.append(" detail");
            }
            if (isContextsChanged()) {
                builder.append(" contexts");
            }
            if (isProjectChanged()) {
                builder.append(" project");
            }
            if (isShowFromChanged()) {
                builder.append(" showFrom");
            }
            if (isDueChanged()) {
                builder.append(" due");
            }
            if (isAllDayChanged()) {
                builder.append(" allDay");
            }
            if (isCompleteChanged()) {
                builder.append(" complete");
            }
            if (isOrderChanged()) {
                builder.append(" order");
            }
        } else {
            builder.append(" unchanged");
        }
        builder.append(']');
        return builder.toString();
    }


}
