package datastore;

public interface Datastore {

	void createDatabase(Database database);

	void deleteDatabase(Database database);

	void updateDatabase(Database database);

	void createCollection(Collection collection);

	void deleteCollection(Collection collection);

	void updateCollection(Collection collection);

	void createRecord(Record record);

	void deleteRecord(Record record);

	void updateRecord(Record record);
}
