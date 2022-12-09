export interface IntentSenderPlugin {
}

export interface Intent {

    /**
     * The action to be performed
     */
    action: string;

    /**
     * The data to operate on, expressed as a URI
     */
    data?: string;

    /**
     * Additional information about the given action
     */
    categories?: string[];

    /**
     * The explicit type of the given data
     */
    type?: string;

    /**
     * The explicit name of the target component class
     */
    component?: {
        package: string;
        class: string;
    };

    /**
     * Any additional information to be passed to the target component
     */
    extras?: { [key: string]: unknown };

    /**
     * Special flags controlling how the Intent is handled
     */
    flags?: number;
}
