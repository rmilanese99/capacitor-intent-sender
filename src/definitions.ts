export interface IntentSenderPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
