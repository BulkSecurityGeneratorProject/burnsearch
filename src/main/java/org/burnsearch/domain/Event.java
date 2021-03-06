package org.burnsearch.domain;

import com.google.common.collect.Lists;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * An event at Burning Man.
 */
@Document(indexName = "burn", type = "event", shards = 1, refreshInterval = "-1")
public class Event {

  public Event() {

  }

  public Event(Event event) {
    this.setAllDay(event.getAllDay());
    this.setCheckLocation(event.getCheckLocation());
    this.setDescription(event.getDescription());
    this.setEventType(event.getEventType());
    this.setHostingCamp(event.getHostingCamp());
    this.setId(event.getId());
    this.setLocatedAtArt(event.getLocatedAtArt());
    this.setOccurrenceSet(event.getOccurrenceSet());
    this.setOtherLocation(event.getOtherLocation());
    this.setPrintDescription(event.getPrintDescription());
    this.setSlug(event.getSlug());
    this.setTitle(event.getTitle());
    this.setUrl(event.getUrl());
    this.setYear(event.getYear());
    this.setUnofficialMapLocation(event.getUnofficialMapLocation());
  }
  @Id
  private Long id;

  @Field(type = FieldType.String, indexAnalyzer = "english", searchAnalyzer = "english")
  private String description;

  @Field(type = FieldType.String, indexAnalyzer = "english", searchAnalyzer = "english")
  private String printDescription;

  @Field(type = FieldType.String, indexAnalyzer = "standard", searchAnalyzer = "standard")
  private String title;

  @Field(type = FieldType.Object)
  private HostingCampReference hostingCamp;

  @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
  private String url;

  @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
  private String slug;

  @Field(type = FieldType.Boolean)
  private boolean allDay;

  @Field(type = FieldType.Date, format = DateFormat.year)
  private Date year;

  @Field(type = FieldType.Object)
  private EventType eventType;

  @Field(type = FieldType.Object)
  private LocatedAtArt locatedAtArt;

  @Field(type = FieldType.Boolean)
  private boolean checkLocation;

  @Field(type = FieldType.String, indexAnalyzer = "standard", searchAnalyzer = "standard")
  private String otherLocation;

  @Field(type = FieldType.Nested)
  private List<EventOccurrence> occurrenceSet;

  @Field(type = FieldType.String, indexAnalyzer = "standard", searchAnalyzer = "standard")
  private String unofficialMapLocation;

  public String getUnofficialMapLocation() {
    return unofficialMapLocation;
  }

  public void setUnofficialMapLocation(String unofficialMapLocation) {
    this.unofficialMapLocation = unofficialMapLocation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrintDescription() {
    return printDescription;
  }

  public void setPrintDescription(String printDescription) {
    this.printDescription = printDescription;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean getAllDay() {
    return allDay;
  }

  public void setAllDay(boolean isAllDay) {
    this.allDay = isAllDay;
  }

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
  }

  public boolean getCheckLocation() {
    return checkLocation;
  }

  public void setCheckLocation(boolean isCheckLocation) {
    this.checkLocation = isCheckLocation;
  }

  public String getOtherLocation() {
    return otherLocation;
  }

  public void setOtherLocation(String otherLocation) {
    this.otherLocation = otherLocation;
  }

  public List<EventOccurrence> getOccurrenceSet() {
    return occurrenceSet;
  }

  public void setOccurrenceSet(List<EventOccurrence> occurrenceSet) {
    this.occurrenceSet = occurrenceSet;
  }

  public HostingCampReference getHostingCamp() {
    return hostingCamp;
  }

  public void setHostingCamp(HostingCampReference hostingCamp) {
    this.hostingCamp = hostingCamp;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public LocatedAtArt getLocatedAtArt() {
    return locatedAtArt;
  }

  public void setLocatedAtArt(LocatedAtArt locatedAtArt) {
    this.locatedAtArt = locatedAtArt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Event event = (Event) o;

    if (allDay != event.allDay) return false;
    if (checkLocation != event.checkLocation) return false;
    if (id != null ? !id.equals(event.id) : event.id != null) return false;
    if (description != null ? !description.equals(event.description) : event.description != null)
      return false;
    if (printDescription != null ? !printDescription.equals(event.printDescription) : event.printDescription != null)
      return false;
    if (title != null ? !title.equals(event.title) : event.title != null) return false;
    if (hostingCamp != null ? !hostingCamp.equals(event.hostingCamp) : event.hostingCamp != null)
      return false;
    if (url != null ? !url.equals(event.url) : event.url != null) return false;
    if (slug != null ? !slug.equals(event.slug) : event.slug != null) return false;
    if (year != null ? !year.equals(event.year) : event.year != null) return false;
    if (eventType != null ? !eventType.equals(event.eventType) : event.eventType != null)
      return false;
    if (locatedAtArt != null ? !locatedAtArt.equals(event.locatedAtArt) : event.locatedAtArt != null)
      return false;
    if (otherLocation != null ? !otherLocation.equals(event.otherLocation) : event.otherLocation != null)
      return false;
    return !(occurrenceSet != null ? !occurrenceSet.equals(event.occurrenceSet) : event.occurrenceSet != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (printDescription != null ? printDescription.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (hostingCamp != null ? hostingCamp.hashCode() : 0);
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (slug != null ? slug.hashCode() : 0);
    result = 31 * result + (allDay ? 1 : 0);
    result = 31 * result + (year != null ? year.hashCode() : 0);
    result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
    result = 31 * result + (locatedAtArt != null ? locatedAtArt.hashCode() : 0);
    result = 31 * result + (checkLocation ? 1 : 0);
    result = 31 * result + (otherLocation != null ? otherLocation.hashCode() : 0);
    result = 31 * result + (occurrenceSet != null ? occurrenceSet.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Event{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", printDescription='" + printDescription + '\'' +
        ", title='" + title + '\'' +
        ", hostingCamp=" + hostingCamp +
        ", url='" + url + '\'' +
        ", slug='" + slug + '\'' +
        ", allDay=" + allDay +
        ", year=" + year +
        ", eventType=" + eventType +
        ", locatedAtArt=" + locatedAtArt +
        ", checkLocation=" + checkLocation +
        ", otherLocation='" + otherLocation + '\'' +
        ", occurrenceSet=" + occurrenceSet +
        '}';
  }
}
